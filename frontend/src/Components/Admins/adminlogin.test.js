import React from 'react';
import { shallow, configure } from 'enzyme';
import AdminLogin from './AdminLogin';
import Adapter from 'enzyme-adapter-react-16';

configure({ adapter: new Adapter() });

describe('Test cases for testing AdminLogin', () => {
    let wrapper;
    test('username check', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'cathy' } });
        expect(wrapper.find('input[type="text"]').props()).toEqual('cathy');
    })

    it('password check', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '1234' } });
        expect(wrapper.find('input[type="password"]').props()).toEqual('1234');
    })

    it('AdminLogin check with correct login information', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'cathy' } });
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '1234' } });
        const container = wrapper.find('button');
        expect(container.length).toEqual(1);
        container.simulate('click');
        expect(wrapper.state('hasAdminLoginFailed')).toBe(true);
    })

    it('AdminLogin check with wrong login information', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'cathy' } });
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '123' } });
        const container = wrapper.find('button');
        expect(container.length).toEqual(1);
        container.simulate('click');
        expect(wrapper.state('hasAdminLoginFailed')).toBe(false);
    })
})