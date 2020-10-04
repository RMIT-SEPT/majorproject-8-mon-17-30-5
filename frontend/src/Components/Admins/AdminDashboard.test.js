import React from 'react';
import { configure, mount } from 'enzyme';
import { MemoryRouter } from 'react-router';
import BookingPage from './AdminDashboard';
import WorkerPage from './AdminDashboard';
import App from '../../App';
import ErrorPage from '../Layout/ErrorPage';
import Adapter from 'enzyme-adapter-react-16';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';
import AdminDashboard from './AdminDashboard';

afterEach(cleanup);
configure({ adapter: new Adapter() });

  test('invalid path should redirect to error page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={[ '/' ]}>
        <App/>
      </MemoryRouter>
    );
    expect(wrapper.find(WorkerPage)).toHaveLength(0);
    expect(wrapper.find(BookingPage)).toHaveLength(0);
    expect(wrapper.find(ErrorPage)).toHaveLength(0);
  });

it("render admin dashboard correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<AdminDashboard/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(9);
});
