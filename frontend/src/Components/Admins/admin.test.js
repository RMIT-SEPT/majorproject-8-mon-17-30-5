import React from 'react';
import { shallow } from 'enzyme';
import AdminLogin from './AdminLogin';

describe('Test cases for testing AdminLogin', () => {
    let wrapper;
    test('username check', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'cathy' } });
        expect(wrapper.state('username')).toEqual('cathy');
    })

    it('password check', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '1234' } });
        expect(wrapper.state('password')).toEqual('1234');
    })

    it('AdminLogin check with correct login information', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'cathy' } });
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '1234' } });
        wrapper.find('button').simulate('click');
        expect(wrapper.state('hasAdminLoginFailed')).toBe(true);
    })

    it('AdminLogin check with wrong login information', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'cathy' } });
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '123' } });
        wrapper.find('button').simulate('click');
        expect(wrapper.state('hasAdminLoginFailed')).toBe(false);
    })
})